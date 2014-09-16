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
  def "deplacement du pion correcte"() {

    given: "un pion dans une position donnée"
    def pion = new Pion(positionHorizontale: posHor, positionVerticale: posVer, pieceCouleur: couleur)

    when: "un déplacement correct du pion est exécutée"
    def depOk = pion.bouge(depHor, depVer)

    then: "le déplacement est correctement effectué"
    depOk == true

    and:"la position du pion est bien mise à jour"
    pion.positionHorizontale == ((int)posHor)+depHor
    pion.positionVerticale == posVer+depVer


    where:
    couleur | posHor | posVer | depHor | depVer
    BLANC   | "a"    | 2      | 0      | 2
    BLANC   | "a"    | 3      | 0      | 1
    NOIR    | "a"    | 7      | 0      | -1

  }

    @Unroll
    def "deplacement du pion incorrecte"() {

        given: "un pion dans une position donnée"
        def pion = new Pion(positionHorizontale: posHor, positionVerticale: posVer, pieceCouleur: couleur)

        when: "un déplacement incorrect du pion est exécuté"
        def depOk = pion.bouge(depHor, depVer)

        then: "le déplacement est indiqué comme non effectué"
        depOk == false

        and:"le pion est resté dans sa position initiale"
        pion.positionHorizontale == (int)posHor
        pion.positionVerticale == posVer

        where:
        couleur | posHor | posVer | depHor | depVer
        BLANC   | "a"    | 2      | 0      | 3
        BLANC   | "a"    | 3      | 0      | 2
        BLANC   | "a"    | 3      | 0      | -1
        NOIR    | "a"    | 7      | 0      | 1

    }

}
