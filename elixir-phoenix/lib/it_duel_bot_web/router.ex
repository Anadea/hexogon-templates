defmodule ItDuelBotWeb.Router do
  use ItDuelBotWeb, :router

  pipeline :api do
    plug :accepts, ["json"]
  end

  scope "/", ItDuelBotWeb do
    pipe_through :api
    resources "/games", GamesController
  end
end
