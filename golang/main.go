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
	json.NewEncoder(w).Encode(ClientMove{ Status: "ok", Figure: 0 })
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
	Width int `json:"width"`
	Height int `json:"height"`
	FiguresCount int `json:"figures_count"`
	Cells [][]int `json:"cells"`
}

type ClientMove struct {
	Status string `json:"status"`
	Figure int `json:"figure"`
}

type Game struct {
	Id string `json:"id"`
	Board Board `json:"board"`
}

type ResponseStatus struct {
	Status string `json:"status"`
}

type ServerMove struct {
	Figure int `json:"figure"`
	Color int `json:"color"`
}
