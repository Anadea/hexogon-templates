defmodule FourColorBots.GamesController do
  use ItDuelBotWeb, :controller

  require Logger

  def create(conn, params) do
    Logger.info inspect(params)
    json conn |> put_status(200), %{status: "ok"}
  end

  def show(conn, params) do
    Logger.info inspect(params)
    json conn |> put_status(200), %{status: "ok", figure: 0}
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
