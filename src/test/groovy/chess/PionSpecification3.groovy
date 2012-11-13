package chess

import spock.lang.Specification
import spock.lang.Unroll

import static chess.PieceCouleur.BLANC
import static chess.PieceCouleur.NOIR

/**
 *
 * @author franck Silvestre
 */
class PionSpecification3 extends Specification {

  @Unroll
  def "deplacement du pion"() {

    setup:
    def pion = new Pion(positionHorizontale: posHor, positionVerticale: posVer, pieceCouleur: couleur)

    when:
    def depOk = pion.bouge(depHor, depVer)

    then:
    depOk == depCorrect
    if (depOk) {
      pion.positionHorizontale == ((int)posHor)+depHor
      pion.positionVerticale == posVer+depVer
    }

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
