use Mix.Config

# In this file, we keep production configuration that
# you'll likely want to automate and keep away from
# your version control system.
#
# You should document the content of this
# file or create a script for recreating it, since it's
# kept out of version control and might be hard to recover
# or recreate for your teammates (or yourself later on).
config :it_duel_bot, ItDuelBotWeb.Endpoint,
  secret_key_base: "uZpACSK3c+GB/oBDq9JJhPOaFpGWh9OiWm3/fvaSaM3rB3AO+gzS2jXV/nRa+AUd"

# Configure your database
config :it_duel_bot, ItDuelBot.Repo,
  adapter: Ecto.Adapters.Postgres,
  username: "postgres",
  password: "postgres",
  database: "it_duel_bot_prod",
  pool_size: 0
