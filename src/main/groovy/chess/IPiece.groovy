package chess

/**
 * 
 * @author franck Silvestre
 */
interface IPiece {

  PieceCouleur getPieceCouleur()
  Integer getPositionHorizontale()
  Integer getPositionVerticale()
  Boolean bouge(Integer depH, Integer depV)
  Boolean checkPosition(Integer posH, Integer posV)
  Boolean checkDeplacement(Integer posH, Integer posV)

}
