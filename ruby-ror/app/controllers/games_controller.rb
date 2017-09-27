class GamesController < ApplicationController

  def create
    p params
    render json: {status: :ok}
  end

  def show
    p params
    render json: {
      status: :ok,
      move_from: [0,2],
      move_to: [0,3]
    }
  end

  def update
    p params
    render json: {status: :ok}
  end

  def destroy
    p params
    render json: {status: :ok}
  end

end
