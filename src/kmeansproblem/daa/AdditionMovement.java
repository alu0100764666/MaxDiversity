package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class AdditionMovement implements Movement{

	@Override
	/**
	 * Añade el elemento marcado por index a la solucion.
	 */
	public KMeansSolution makeMove(KMeansSolution solution, int index) {
		solution.addElement(index);
		return solution;
	}

}
