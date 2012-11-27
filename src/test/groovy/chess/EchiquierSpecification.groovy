package chess

import spock.lang.Specification
import spock.lang.Unroll

import static chess.PieceCouleur.BLANC
import static chess.PieceCouleur.NOIR

/**
 *
 * @author franck Silvestre
 */
class EchiquierSpecification extends Specification {

  Echiquier echiquier

  def setup() {
    echiquier = new Echiquier()
  }

  @Unroll
  def "recuperation piece sur echiquier"(Integer posHor, Integer posVert,
                                         Boolean pieceExiste, PieceCouleur couleur, Class typePiece) {
    when:
    Piece piece = echiquier.get(posHor, posVert)

    then:
    if (piece) {
      pieceExiste == true
      piece.pieceCouleur == couleur
      piece.positionHorizontale == posHor
      piece.positionVerticale == posVert
      piece.class == typePiece
    } else {
      pieceExiste == false
    }

    where:
    posHor | posVert | pieceExiste | couleur | typePiece
    "a"    | 2       | true        | BLANC   | Pion.class
    "d"    | 2       | true        | BLANC   | Pion.class
    "a"    | 7       | true        | NOIR    | Pion.class
    "d"    | 7       | true        | NOIR    | Pion.class
    "a"    | 3       | false       | NOIR    | Pion.class

  }

  @Unroll
  def "deplacement pion sur echiquier"(Integer posHor, Integer posVert,
                                       Integer depHor, Integer depVert) {

    when:
    Piece piece = echiquier.get(posHor, posVert)
    echiquier.deplacePiece(posHor, posVert, depHor, depVert)

    then:
    echiquier.get(posHor, posVert) == null
    piece.positionHorizontale == posHor + depHor
    piece.positionVerticale == posVert + depVert
    echiquier.get(posHor + depHor, posVert + depVert) == piece

    where:
    posHor | posVert | depHor | depVert
    "a"    | 2       |    0   |   1
    "d"    | 2       |    0   |   2
    "a"    | 7       |    0   |   -2
    "d"    | 7       |    0   |   -1

  }

}
