package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import structure.problemsolvingmethods.daa.SolutionMethod;


/**
 * Algoritmo GRASP con una busqueda local como post-procesamiento.
 * @author sabato
 *
 */
public class GRASPandLocalSearch extends SolutionMethod {
	private ConstructiveGRASP grasp;
	private LocalSearch localSearch;
	
	/**
	 * 
	 * @param problem Problema a resolver
	 * @param lrc Tamaño de la lista restringida de candidatos.
	 * @param type Tipo, si añade o quita nodos.
	 */
	public GRASPandLocalSearch(KMeansProblem problem, int lrc, int type) {
		setProblem(problem);
		if (type == ConstructiveGRASP.DIRECT)
			setGrasp(new DirectConstructiveGRASP(problem, lrc));
		else
			setGrasp(new ReverseConstructiveGRASP(problem, lrc));
		
	}
	@Override
	public void runSearch() {
		getGrasp().runSearch();
		setLocalSearch(new LocalSearch((KMeansProblem)getProblem(), (KMeansSolution)getGrasp().getBestSolution()));
		getLocalSearch().runSearch();
		setBestSolution(getLocalSearch().getBestSolution());
	}
	private ConstructiveGRASP getGrasp() {
		return grasp;
	}
	private void setGrasp(ConstructiveGRASP grasp) {
		this.grasp = grasp;
	}
	private LocalSearch getLocalSearch() {
		return localSearch;
	}
	private void setLocalSearch(LocalSearch localSearch) {
		this.localSearch = localSearch;
	}
	
}
