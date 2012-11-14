package chess

import spock.lang.Specification
import spock.lang.Unroll

import static chess.PieceCouleur.BLANC
import static chess.PieceCouleur.NOIR

/**
 *
 * @author franck Silvestre
 */
class EchiquierSpecification2 extends Specification {

  Echiquier echiquier = new Echiquier()
  IPiece piece = Mock()


  @Unroll
  def "Interaction echiquier piece"() {

    when:
    echiquier.deplacePiece(piece, 0,1)

    then:
    1*piece.bouge(0,1)
    _ * _

  }

}
