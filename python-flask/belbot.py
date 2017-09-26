#!/usr/bin/env python
import os
from flask import Flask, request, jsonify
import json

app = Flask(__name__)


@app.route('/games', methods=['POST'])
def post_handler():
    print('[POST] /games')
    data = json.loads(request.data)
    print(data)
    return jsonify(status='ok')


@app.route('/games/<string:id>', methods=['GET'])
def get_handler(id):
    print('[GET] games/:id')
    print(id)
    print(request.args)
    return jsonify(status='ok', figure=0)


@app.route('/games/<string:id>', methods=['PUT'])
def put_handler(id):
    print('[PUT] games/:id')
    print(id)
    data = json.loads(request.data)
    print(data)
    return jsonify(status='ok')


@app.route('/games/<string:id>', methods=['DELETE'])
def delete_handler(id):
    print('[DELETE] /games/:id')
    print(id)
    return jsonify(status='ok')


@app.route('/')
def index():
    print('root')
    return '.'


def main():
    port = int(os.environ.get('PORT', 8000))
    app.debug = True
    app.run(host='0.0.0.0', port=port)


if __name__ == '__main__':
    main()
