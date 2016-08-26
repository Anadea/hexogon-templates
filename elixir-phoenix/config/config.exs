# This file is responsible for configuring your application
# and its dependencies with the aid of the Mix.Config module.
#
# This configuration file is loaded before any dependency and
# is restricted to this project.
use Mix.Config

# Configures the endpoint
config :four_color_bots, FourColorBots.Endpoint,
  url: [host: "localhost"],
  secret_key_base: "dYP8Hi1B23n8T85l531827gYICbpAuVRLPkXuki4UQPwGExE/JA36Uf1U7eGzzYM",
  render_errors: [view: FourColorBots.ErrorView, accepts: ~w(json)],
  pubsub: [name: FourColorBots.PubSub,
           adapter: Phoenix.PubSub.PG2]

# Configures Elixir's Logger
config :logger, :console,
  format: "$time $metadata[$level] $message\n",
  metadata: [:request_id]

# Import environment specific config. This must remain at the bottom
# of this file so it overrides the configuration defined above.
import_config "#{Mix.env}.exs"
