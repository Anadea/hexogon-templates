package main

import (
	"fmt"
	"net/http"
	"encoding/json"

	"github.com/gorilla/mux"
	"os"
)

func startGame(w http.ResponseWriter, r *http.Request) {
	fmt.Println("startGame endpoint hit")
	game := Game{}
	json.NewDecoder(r.Body).Decode(&game)

	fmt.Printf("%+v\n", game)

	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(ResponseStatus{Status: "ok"})
}

func makeMove(w http.ResponseWriter, r *http.Request) {
	fmt.Println("makeMove endpoint hit")
	vars := mux.Vars(r)
	gameId := vars["id"]
	color := r.URL.Query()["color"][0]

	fmt.Println("gameId=" + gameId)
	fmt.Println("color=" + color)

	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(ClientMove{ Status: "ok", MoveFrom: [2]int{0,2}, MoveTo: [2]int{0,3} })
}

func handleMove(w http.ResponseWriter, r *http.Request) {
	fmt.Println("handleMove endpoint hit")
	vars := mux.Vars(r)
	gameId := vars["id"]
	serverMove := ServerMove{}
	json.NewDecoder(r.Body).Decode(&serverMove)

	fmt.Println("gameId=" + gameId)
	fmt.Printf("%+v\n", serverMove)

	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(ResponseStatus{Status: "ok"})
}

func finishGame(w http.ResponseWriter, r *http.Request) {
	fmt.Println("finishGame endpoint hit")
	vars := mux.Vars(r)
	gameId := vars["id"]

	fmt.Println("gameId=" + gameId)

	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(ResponseStatus{Status: "ok"})
}

func handleRequests(router *mux.Router) {
	router.HandleFunc("/games", startGame).Methods("POST")
	router.HandleFunc("/games/{id}", makeMove).Methods("GET")
	router.HandleFunc("/games/{id}", handleMove).Methods("PUT")
	router.HandleFunc("/games/{id}", finishGame).Methods("DELETE")
}

func main() {
	router := mux.NewRouter()
	handleRequests(router)

	dbUrl := os.Getenv("DATABASE_URL")
	fmt.Println("Database URL: " + dbUrl)

	http.ListenAndServe(":"+os.Getenv("PORT"), router)
}

type Board struct {
	Size int `json:"size"`
	Cells [][]int `json:"cells"`
}

type Jumps struct {
	First int `json:"1"`
	Second int `json:"2"`
}

type ClientMove struct {
	Status string `json:"status"`
	MoveFrom [2]int `json:"move_from"`
	MoveTo [2]int `json:"move_to"`
}

type Game struct {
	Id string `json:"id"`
	FirstTurn bool `json:"first_turn"`
	Training bool `json:"training"`
	Jumps Jumps `json:"jumps"`
	Board Board `json:"board"`
}

type ResponseStatus struct {
	Status string `json:"status"`
}

type ServerMove struct {
	Jumps Jumps `json:"jumps"`
	Changes [][]int `json:"changes"`
}
