package chess

/**
 *
 * @author franck Silvestre
 */
class Echiquier {
  def grille

  /**
   * Initialise l'échiquier avec une grille de début de partie
   */
  Echiquier() {
    grille = [[null, null, null, null, null, null, null, null],
            [null, null, null, null, null, null, null, null],
            [null, null, null, null, null, null, null, null],
            [null, null, null, null, null, null, null, null],
            [null, null, null, null, null, null, null, null],
            [null, null, null, null, null, null, null, null],
            [null, null, null, null, null, null, null, null],
            [null, null, null, null, null, null, null, null]]
    8.times {
      grille[it][1] = new Pion(pieceCouleur: PieceCouleur.BLANC,
                               positionHorizontale: ((int) "a") + it,
                               positionVerticale: 2)
    }
    8.times {
      grille[it][6] = new Pion(pieceCouleur: PieceCouleur.NOIR,
                               positionHorizontale: ((int) "a") + it,
                               positionVerticale: 7)
    }
  }

  /**
   * Récupère une pièce sur l'échiquier
   * @param positionHor
   * @param positionVert
   * @return la pièce ou null
   */
  IPiece get(Integer positionHor, Integer positionVert) {
    grille[positionHor - ((int) "a")][positionVert - 1]
  }

  /**
   * Déplace une plièce sur l'échiquier
   * @param posHor
   * @param posVer
   * @param deplHor
   * @param deplVert
   * @return truee si déplaceement OK, false sinon
   */
  Boolean deplacePiece(Integer posHor, Integer posVer, Integer deplHor, Integer deplVert) {
    def piece = get(posHor, posVer)
    if (!piece) {
      return false
    }
    deplacePiece(piece,deplHor,deplVert)
  }

  /**
     * Déplace une plièce sur l'échiquier
     * @param posHor
     * @param posVer
     * @param deplHor
     * @param deplVert
     * @return truee si déplaceement OK, false sinon
     */
    Boolean deplacePiece(IPiece piece, Integer deplHor, Integer deplVert) {
      def posHor = piece.positionHorizontale
      def posVer = piece.positionVerticale
      def depOk = piece.bouge(deplHor, deplVert)
      if (!depOk) {
        return false
      }
      grille[posHor- ((int) "a")][posVer-1] = null
      grille[piece.positionHorizontale - ((int) "a")][piece.positionVerticale - 1] = piece
      true
    }


}
