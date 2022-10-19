#
#   Weather update server
#   Binds PUB socket to tcp://*:5556
#   Publishes random weather updates
#
import zmq
from random import randrange

context = zmq.Context()
socket = context.socket(zmq.PUB)
socket.bind("tcp://*:5556")

while True:
    zipcode = randrange(79600000, 79650999)
    temperature = randrange(0, 51)
    rel_humidity = randrange(10, 60)

    socket.send_string(f"{zipcode} {temperature} {rel_humidity}")
