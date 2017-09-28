defmodule FourColorBots.Router do
  use Plug.Router

  import FourColorBots.JsonResponse, only: [render: 2]

  require Logger

  plug Plug.RequestId
  plug Plug.Logger

  plug Plug.Parsers, parsers: [:json],
    pass:  ["*/*"],
    json_decoder: Poison

  if Mix.env == :dev do
    use Plug.Debugger
  end

  plug :match
  plug :dispatch

  post "/games" do
    Logger.info inspect(conn.params)
    render conn, %{status: "ok"}
  end

  get "/games/:id" do
    Logger.info id
    Logger.info inspect(conn.params)
    render conn, %{status: "ok", move_from: [0,2], move_to: [0,3]}
  end

  put "/games/:id" do
    Logger.info id
    Logger.info inspect(conn.params)
    render conn, %{status: "ok"}
  end

  delete "/games/:id" do
    Logger.info id
    Logger.info inspect(conn.params)
    render conn, %{status: "ok"}
  end

  match _ do
    send_resp conn, 404, "Not Found"
  end
end
