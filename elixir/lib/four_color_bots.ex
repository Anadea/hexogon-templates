defmodule FourColorBots do
  use Application

  # See http://elixir-lang.org/docs/stable/elixir/Application.html
  # for more information on OTP Applications
  def start(_type, _args) do
    import Supervisor.Spec, warn: false

    children = [
      worker(__MODULE__, [], function: :run)
    ]

    # See http://elixir-lang.org/docs/stable/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: FourColorBots.Supervisor]
    Supervisor.start_link(children, opts)
  end

  def run do
    {port, _} = try do
      Integer.parse(System.get_env("PORT"))
    rescue
      FunctionClauseError -> {4000, ""}
    end

    {:ok, _} = Plug.Adapters.Cowboy.http FourColorBots.Router, [], port: port
  end
end
