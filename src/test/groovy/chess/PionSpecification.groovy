package chess

import spock.lang.Specification

/**
 * 
 * @author franck Silvestre
 */
class PionSpecification extends Specification{

   def "deplacement du pion"() {

     expect:
      new Pion(positionHorizontale: "a", positionVerticale: 2, pieceCouleur: PieceCouleur.BLANC).bouge(0,3) == false
      new Pion(positionHorizontale: "a", positionVerticale: 2, pieceCouleur: PieceCouleur.BLANC).bouge(0,2) == true
      new Pion(positionHorizontale: "a", positionVerticale: 3, pieceCouleur: PieceCouleur.BLANC).bouge(0,2) == false
      new Pion(positionHorizontale: "a", positionVerticale: 3, pieceCouleur: PieceCouleur.BLANC).bouge(0,1) == true

   }

}
