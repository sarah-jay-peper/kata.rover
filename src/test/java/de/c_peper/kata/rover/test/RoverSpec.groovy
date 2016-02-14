package de.c_peper.kata.rover.test

import de.c_peper.kata.rover.Rover
import spock.lang.Specification
import spock.lang.Unroll

class RoverSpec extends Specification {

    @Unroll
    def "Basic movement: #testName"() {
        given: "new Rover"
        def rover = new Rover()

        when: "movement input"
        rover.processInput(input)

        then: "expect result"
        rover.getPositionString() == result

        where:
        input | result  | testName
        'R'   | "0,0,E" | "turn right"
        'L'   | "0,0,W" | "turn left"
        'F'   | "0,1,N" | "move forward"
        'B'   | "0,9,N" | "move backward"
    }

    @Unroll
    def "sideways movement: #testName"() {
        given: "new Rover"
        def rover = new Rover()

        when: "movement input"
        rover.processInput(input)

        then: "expect result"
        rover.getPositionString() == result

        where:
        input   | result  | testName
        "RF"    | "1,0,E" | "turn right, move forward"
        "RFF"   | "2,0,E" | "turn right, move twice forward"
        "RFFBB" | "0,0,E" | "turn right, move twice forward, twice backward"
        "LF"    | "9,0,W" | "turn left, move forward"
        "LFF"   | "8,0,W" | "turn left, move twice forward"
        "LFFBB" | "0,0,W" | "turn left, move twice forward, twice backward"
    }

    @Unroll
    def "north/south movement: #testName"() {
        given: "new Rover"
        def rover = new Rover()

        when: "movement input"
        rover.processInput(input)

        then: "expect result"
        rover.getPositionString() == result

        where:
        input          | result  | testName
        "FF"           | "0,2,N" | "move twice forward"
        "FFBB"         | "0,0,N" | "move twice forward, twice backward"
        "BB"           | "0,8,N" | "move twice backward"
        "BBFF"         | "0,0,N" | "move twice backward, twice forward"
        "FFFFFFFFFF"   | "0,0,N" | "move forward ten times"
        "BBBBBBBBBB"   | "0,0,N" | "move backward ten times"
        "RRFF"         | "0,8,S" | "face south, move twice forward"
        "RRFFBB"       | "0,0,S" | "face south, move twice forward, twice backward"
        "RRBB"         | "0,2,S" | "face south, move twice backward"
        "RRBBFF"       | "0,0,S" | "face south, move twice backward, twice forward"
        "RRFFFFFFFFFF" | "0,0,S" | "face south, move forward ten times"
        "RRBBBBBBBBBB" | "0,0,S" | "face south, move backward ten times"
    }

    @Unroll
    def "obstacle avoidance: #testName"() {
        given: "new Rover"
        def rover = new Rover()

        and: "obstacle"
        rover.addObstacle(obsX, obsY);

        when: "movement input"
        rover.processInput(input)

        then: "expect result"
        rover.getPositionString() == result

        where:
        input  | result  | obsX | obsY | testName
        "FF"   | "0,1,N" | 0    | 2    | "obstacle at 0/2"
        "RFF"  | "1,0,E" | 2    | 0    | "obstacle at 2/0"
        "LFF"  | "9,0,W" | 8    | 0    | "obstacle at 8/0"
        "RBB"  | "9,0,E" | 8    | 0    | "obstacle at 8/0, driving backwards"
        "BB"   | "0,9,N" | 0    | 8    | "obstacle at 0/8, driving backwards"
        "RRFF" | "0,9,S" | 0    | 8    | "obstacle at 0/8"
    }

    @Unroll
    def "obstacle avoidance, ignore extra movements: #testName"() {
        given: "new Rover"
        def rover = new Rover()

        and: "obstacle"
        rover.addObstacle(obsX, obsY);

        when: "movement input"
        rover.processInput(input)

        then: "expect result"
        rover.getPositionString() == result

        where:
        input    | result  | obsX | obsY | testName
        "FFF"    | "0,1,N" | 0    | 2    | "obstacle at 0/2, keep going north"
        "FFRF"   | "0,1,N" | 0    | 2    | "obstacle at 0/2, going east at obstacle"
        "RFFRF"  | "1,0,E" | 2    | 0    | "obstacle at 2/0, going south at obstacle"
        "LFFLF"  | "9,0,W" | 8    | 0    | "obstacle at 8/0, going west at obstacle"
        "RRFFRF" | "0,9,S" | 0    | 8    | "obstacle at 0/8, going west at obstacle"
    }
}
