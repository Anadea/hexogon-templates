defmodule FourColorBots.JsonResponse do
  import Plug.Conn

  def render(conn, map) do
    conn
    |> put_resp_content_type("application/json")
    |> send_resp(200, Poison.encode!(map))
  end
end
