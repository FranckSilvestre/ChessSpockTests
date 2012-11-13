package chess

import spock.lang.Specification
import spock.lang.Unroll

import static chess.PieceCouleur.BLANC
import static chess.PieceCouleur.NOIR

/**
 *
 * @author franck Silvestre
 */
class PionSpecification2 extends Specification {

  @Unroll
  def "deplacement du pion"() {

    expect:
    new Pion(positionHorizontale: posHor, positionVerticale: posVer, pieceCouleur: couleur).bouge(depHor, depVer) == depCorrect

    where:
    couleur | posHor | posVer | depHor | depVer | depCorrect
    BLANC   | "a"    | 2      | 0      | 3      | false
    BLANC   | "a"    | 2      | 0      | 2      | true
    BLANC   | "a"    | 3      | 0      | 2      | false
    BLANC   | "a"    | 3      | 0      | 1      | true
    BLANC   | "a"    | 3      | 0      | -1     | false
    NOIR    | "a"    | 7      | 0      | -1     | true
    NOIR    | "a"    | 7      | 0      | 1      | false

  }

}
