class GamesController < ApplicationController

  def create
    p params
    render json: {status: :ok}
  end

  def show
    p params
    render json: {
      status: :ok,
      figure: 0
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
