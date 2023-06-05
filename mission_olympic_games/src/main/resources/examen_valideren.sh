#!/bin/bash
echo Enter port number:
read PORT
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 1: OVERZICHT ATLETEN\n'
curl -H Content-Type:application/json http://localhost:$PORT/olympicgames/athletes
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 2: RACES TOEVOEGEN\n'
curl -d '{"discipline": "SPRINT_100M","dateTime": "2021-08-25 15:00:00"}' -H Content-Type:application/json -X POST http://localhost:$PORT/olympicgames/races
curl -d '{"discipline": "LONGDISTANCE_10000M","dateTime": "2021-09-03 22:22:00"}' -H Content-Type:application/json -X POST http://localhost:$PORT/olympicgames/races
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 3: JOIN RACE VALID\n'
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/1/1
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/1/2
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/1/3
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/2/21
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/2/22
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/2/23
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/2/24
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 4: JOIN RACE INVALID\n'
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/1/15
curl -H Content-Type:application/json -X PUT http://localhost:$PORT/olympicgames/races/2/4
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 5: LEAVE RACE\n'
curl -H Content-Type:application/json -X DELETE http://localhost:$PORT/olympicgames/races/2/24
echo $'+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 6: RACE RESULTS\n'
curl -d '{"status": "QUALIFIED","time": "00:00:09.800"}' -H Content-Type:application/json -X POST http://localhost:$PORT/olympicgames/races/1/1
curl -d '{"status": "QUALIFIED","time": "00:00:09.890"}' -H Content-Type:application/json -X POST http://localhost:$PORT/olympicgames/races/1/3
curl -d '{"status": "DISQUALIFIED"}' -H Content-Type:application/json -X POST http://localhost:$PORT/olympicgames/races/1/2
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 7: SERVLET OUTPUT RACE 1\n'
curl -H Content-Type:application/html -X GET http://localhost:$PORT/RaceResults?race=1
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 8: SERVLET OUTPUT RACE 2\n'
curl -H Content-Type:application/html -X GET http://localhost:$PORT/RaceResults?race=2
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo Press any key:
read key
