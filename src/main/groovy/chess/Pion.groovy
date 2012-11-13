package chess

import groovy.transform.ToString

/**
 *
 * @author franck Silvestre
 */
@ToString(includeSuper=true)
class Pion extends Piece {

  @Override
  Boolean checkDeplacement(Integer positionHorCible, Integer positionVertCible) {
    if (positionHorCible != positionHorizontale) {
      return false
    }
    def diffVert = positionVertCible - positionVerticale
    if (this.pieceCouleur == PieceCouleur.BLANC) {
      if (diffVert < 0) {
        return false
      }
      if (positionVerticale > 2 && diffVert > 1) {
        return false
      } else if (positionVerticale == 2 && diffVert > 2) {
        return false
      }
    }
    if (this.pieceCouleur == PieceCouleur.NOIR) {
      if (diffVert > 0) {
        return false
      }
      if (positionVerticale < 7 && diffVert < -1) {
        return false
      } else if (positionVerticale == 7 && diffVert < -2) {
        return false
      }
    }
    true
  }
}
