package chess

import groovy.transform.ToString

/**
 * 
 * @author franck Silvestre
 */
@ToString(includeNames=true)
abstract class Piece {

  PieceCouleur pieceCouleur

  Integer positionHorizontale = "a"
  Integer positionVerticale = 1

  /**
   * Effectue un déplacement de la pièce
   * @param horizontalDep
   * @param verticalDep
   * @return
   */
  Boolean bouge(Integer horizontalDep,Integer  verticalDep) {
    def posHorCible = positionHorizontale + horizontalDep
    def posVerCible = positionVerticale + verticalDep
    if (checkPosition(posHorCible,posVerCible) &&
        checkDeplacement(posHorCible, posVerCible)) {
      positionHorizontale = posHorCible
      positionVerticale = posVerCible
      return true
    }
    false
  }

  /**
   * Vérifie la validité de la position
   * @param positionHor
   * @param positionVert
   * @return true si position valide false sinon
   */
  Boolean checkPosition(Integer positionHor, Integer positionVert) {
    if (positionHor < "a" || positionHor > "h") {
      return false
    }
    if (positionVert < 1 || positionVert > 8) {
          return false
    }
    true
  }

  /**
   * Vérifie la validité d'un déplacement
   * @param positionHor
   * @param positionVert
   * @return true si déplacement valide false sinon
   */
  abstract Boolean checkDeplacement(Integer positionHor, Integer positionVert)

}



enum PieceCouleur {
  BLANC,
  NOIR
}