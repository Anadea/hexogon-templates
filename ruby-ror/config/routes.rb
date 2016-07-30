Rails.application.routes.draw do
  resources :games, only: %i[create show update destroy]
end
