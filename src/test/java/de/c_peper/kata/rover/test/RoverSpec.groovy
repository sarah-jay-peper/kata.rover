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
}
