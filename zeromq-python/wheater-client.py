#
#   Weather update client
#   Connects SUB socket to tcp://localhost:5556
#   Collects weather updates and finds avg temp in zipcode
#

import sys
import zmq

context = zmq.Context()
socket = context.socket(zmq.SUB)

print("Collecting updates from wheater server ...")
socket.connect("tcp://localhost:5556")

# subscribe to zipcode, default is zip code of TL, 79641-162
zip_filter = sys.argv[1] if len(sys.argv) > 1 else "79641162"
socket.setsockopt_string(zmq.SUBSCRIBE, zip_filter)

# process 5 updates
total_temp = 0.0
for update_nbr in range(5):
    string = socket.recv_string()
    zipcode, temperature, rel_humidity = string.split()
    print(f"The temperature #{update_nbr + 1} collected was {float(temperature)}")
    total_temp += int(temperature)

print(f"Average temperature for zipcode " f" '{zip_filter} was {total_temp / (update_nbr + 1)} C")
