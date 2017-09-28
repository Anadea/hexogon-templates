# This file is responsible for configuring your application
# and its dependencies with the aid of the Mix.Config module.
#
# This configuration file is loaded before any dependency and
# is restricted to this project.
use Mix.Config

# General application configuration
config :it_duel_bot,
  ecto_repos: [ItDuelBot.Repo]

# Configures the endpoint
config :it_duel_bot, ItDuelBotWeb.Endpoint,
  url: [host: "localhost"],
  secret_key_base: "oBjALZ5wgskdkHvKYT1lJAHn6I7TWGhq74Td5Vl/165hBfXd60okpz+6X8l7OKS9",
  render_errors: [view: ItDuelBotWeb.ErrorView, accepts: ~w(json)],
  pubsub: [name: ItDuelBot.PubSub,
           adapter: Phoenix.PubSub.PG2]

# Configures Elixir's Logger
config :logger, :console,
  format: "$time $metadata[$level] $message\n",
  metadata: [:request_id]

# Import environment specific config. This must remain at the bottom
# of this file so it overrides the configuration defined above.
import_config "#{Mix.env}.exs"
