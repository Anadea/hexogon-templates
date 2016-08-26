defmodule FourColorBots.Router do
  use FourColorBots.Web, :router

  pipeline :api do
    plug :accepts, ["json"]
  end

   scope "/", FourColorBots do
     pipe_through :api
     resources "/games", GamesController
   end
end
