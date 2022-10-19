import zmq

print(f"Current libzmq version is {zmq.zmq_version()}")
print(f"Current pyzmq version is {zmq.__version__}")