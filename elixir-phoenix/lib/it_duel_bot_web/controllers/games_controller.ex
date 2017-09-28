defmodule ItDuelBotWeb.GamesController do
  use ItDuelBotWeb, :controller

  require Logger

  def create(conn, params) do
    Logger.info inspect(params)
    json conn |> put_status(200), %{status: "ok"}
  end

  def show(conn, params) do
    Logger.info inspect(params)
    json conn |> put_status(200), %{status: "ok", move_from: [0,2], move_to: [0,3]}
  end

  def update(conn, params) do
    Logger.info inspect(params)
    json conn |> put_status(200), %{status: "ok"}
  end

  def delete(conn, params) do
    Logger.info inspect(params)
    json conn |> put_status(200), %{status: "ok"}
  end
end
