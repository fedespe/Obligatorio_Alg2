
package Tads;

public class ArbolBinario implements IArbolBinario{
    
    public NodoArbol raiz;
    public int cantidadNodos;

    //PROPIEDADES
    
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    //CONSTRUCTOR
    
    public ArbolBinario() {
            this.raiz = null;
            this.cantidadNodos=0;
    }

    //***************************************************
    //METODOS BASICOS
    //***************************************************
    
    //PRE:
    //POS: Agrega un nuevo nodo al Arbol
    @Override
    public void add(String clave, Object dato){
            if(this.isEmpty()){
                    NodoArbol nuevo = new NodoArbol(clave, dato);
                    this.raiz = nuevo;
                    this.cantidadNodos++;
            }else{
                    ArbolBinario aux = new ArbolBinario();
                    if (clave.compareTo(this.raiz.getClave())< 0){
                            aux.raiz = this.raiz.getIzq();
                            aux.add(clave, dato);
                            this.raiz.setIzq(aux.raiz);
                    }
                    if (clave.compareTo(this.raiz.getClave()) > 0){
                            aux.raiz = this.raiz.getDer();
                            aux.add(clave, dato);
                            this.raiz.setDer(aux.raiz);
                    }

            }
    }
	
    //PRE:
    //POS: Retorna true si el arbol es vacio
    @Override
    public boolean isEmpty(){
            return (this.raiz == null);
    }
	
    @Override
    //PRE: 
    //POS: Agrega un nuevo nodo al Arbol
    public boolean isHoja(){
        if(!this.isEmpty())
            return ((this.raiz.getIzq() == null) && (this.raiz.getDer() == null));
        else
            return false;
    }
	
    /*
     * Ã�rbol Binario Equilibrado: Es un Ã¡rbol B en el que en todos sus nodos se cumple la siguiente propiedad:
     *  | altura(subÃ¡rbol_izq) â€“ altura(subÃ¡rbol_der) | <= 1
     */	
    //PRE: 
    //POS: Retorna true si el Arbol es equilibrado
    @Override
    public boolean isEquilibrado(){
            if(!this.isEmpty()){
                    ArbolBinario auxDer = new ArbolBinario();
                    auxDer.raiz = this.raiz.getDer();
                    ArbolBinario auxIzq = new ArbolBinario();
                    auxIzq.raiz = this.raiz.getIzq();
                    return Math.abs(auxDer.altura() - auxIzq.altura())<=1;
            }
            return true;
    }
	
    //PRE: 
    //POS: Retorna true si la clave se encuentra en el arbol
    //SE PUEDE MODIFICAR PARA QUE RETORNE EL NODO DEL ARBOL
    @Override
    public boolean existe(String clave){
            if(!this.isEmpty()){
                    ArbolBinario aux = new ArbolBinario();
                    if (clave.compareTo(this.raiz.getClave())==0){
                            return true;
                    }
                    if (clave.compareTo(this.raiz.getClave())<0){
                            aux.raiz = this.raiz.getIzq();
                    }
                    if (clave.compareTo(this.raiz.getClave())>0){
                            aux.raiz = this.raiz.getDer();
                    }
                    return aux.existe(clave);
            }
            return false;
    }
    
    //PRE: 
    //POS: Retorna el nodo encontrado
    @Override
    public NodoArbol buscar(String clave){
            if(!this.isEmpty()){
                    ArbolBinario aux = new ArbolBinario();
                    if (clave.compareTo(this.raiz.getClave())==0){
                            return this.raiz;
                    }
                    if (clave.compareTo(this.raiz.getClave())<0){
                            aux.raiz = this.raiz.getIzq();
                    }
                    if (clave.compareTo(this.raiz.getClave())>0){
                            aux.raiz = this.raiz.getDer();
                    }
                    return aux.buscar(clave);
            }
            return null;
    }
	
    //Post: 0 no existe la clave en el arbol. Si la clave corresponde a la raiz retorna 1.
    @Override
    public int nivel(String clave){
            int respuesta = 0;
            if(!this.isEmpty()){
                    ArbolBinario aux = new ArbolBinario();
                    if (clave.compareTo(this.raiz.getClave())==0){
                            return 1;
                    }

                    if (clave.compareTo(this.raiz.getClave())<0){
                            aux.raiz = this.raiz.getIzq();
                    }
                    if (clave.compareTo(this.raiz.getClave())>0){
                            aux.raiz = this.raiz.getDer();
                    }
                    respuesta = aux.nivel(clave);
                    if (respuesta >0){ 
                            // si existe
                            return respuesta+1;
                    }
            }
            return respuesta;
    }
	
    /*
     * 	Altura. La altura de un Ã¡rbol se define como el nivel del nodo de mayor nivel. 
     */
    //PRE: 
    //POS: Retorna un entero que indica la altura del Arbol
    @Override
    public int altura(){
            if(!this.isEmpty()){
                    ArbolBinario auxDer = new ArbolBinario();
                    auxDer.raiz = this.raiz.getDer();
                    ArbolBinario auxIzq = new ArbolBinario();
                    auxIzq.raiz = this.raiz.getIzq();
                    return max(auxIzq.altura(), auxDer.altura())+1;
            }
            return 0;
    }
	
    private int max(int a, int b){
            if (a<b){
                    return b;
            }
            return a;
    }

    /*
     * Peso. Es el nÃºmero de nodos del Ã¡rbol sin contar la raÃ­z 
     */
    //PRE: 
    //POS: Retorna un entero que indica la cantidad de nodos del Arbol (sin raiz)
    @Override
    public int peso(){
            if(!this.isEmpty()){
                    ArbolBinario auxDer = new ArbolBinario();
                    auxDer.raiz = this.raiz.getDer();
                    ArbolBinario auxIzq = new ArbolBinario();
                    auxIzq.raiz = this.raiz.getIzq();
                    return auxIzq.cantidadNodos() + auxDer.cantidadNodos();
            }
            return 0;
    }
	
    //Se agrego como parametro del arbol para mayor eficiencia
    @Override
    public int cantidadNodos(){
            if(!this.isEmpty()){
                    ArbolBinario auxDer = new ArbolBinario();
                    auxDer.raiz = this.raiz.getDer();
                    ArbolBinario auxIzq = new ArbolBinario();
                    auxIzq.raiz = this.raiz.getIzq();
                    return auxIzq.cantidadNodos() + auxDer.cantidadNodos() + 1;
            }
            return 0;
    }
	
//	public void preOrden(){
//		if(!this.isEmpty()){
//			System.out.print(this.raiz.getClave() + ":"+ this.raiz.getDato() +" - ");
//		
//			ABB auxIzq = new ABB();
//			auxIzq.raiz = this.raiz.getIzq();
//			auxIzq.preOrden();
//		
//			ABB auxDer = new ABB();
//			auxDer.raiz = this.raiz.getDer();
//			auxDer.preOrden();
//		}
//	}
	
    //PRE: 
    //POS: Imprime los nodos del Arbol en orden ascendente 
    //en relacion a su clave
    @Override
    public void inOrden(){
            if(!this.isEmpty()){
                    ArbolBinario auxIzq = new ArbolBinario();
                    auxIzq.raiz = this.raiz.getIzq();
                    auxIzq.inOrden();

                    System.out.print(this.raiz.getClave() + ":"+ this.raiz.getDato().toString() +" - ");

                    ArbolBinario auxDer = new ArbolBinario();
                    auxDer.raiz = this.raiz.getDer();
                    auxDer.inOrden();
            }
    }
    
    public String retornarDatosInOrden(String retorno){
    	if(this.isEmpty()){
    		return "";
    	}
    	
        ArbolBinario auxIzq = new ArbolBinario();
        auxIzq.raiz = this.raiz.getIzq();
        ArbolBinario auxDer = new ArbolBinario();
        auxDer.raiz = this.raiz.getDer();
        
        return retorno + auxIzq.retornarDatosInOrden(retorno) + this.raiz.getDato().toString()+"|" + auxDer.retornarDatosInOrden(retorno); 
    }
	
//	public void postOrden(){
//		if(!this.isEmpty()){
//			ABB auxIzq = new ABB();
//			auxIzq.raiz = this.raiz.getIzq();
//			auxIzq.postOrden();
//			
//			ABB auxDer = new ABB();
//			auxDer.raiz = this.raiz.getDer();
//			auxDer.postOrden();
//			
//			System.out.print(this.raiz.getClave() + ":"+ this.raiz.getDato() +" - ");
//		}
//	}
	
    /* 	
     * METODOS RECOMENDADOS PARA IMPLEMENTAR
     * 
     */

     /* 
      * Camino. Es una secuencia de nodos, en el que dos nodos consecutivos cualesquiera son padre e hijo. 
      * Imprime todos los caminos del arbol
      */
    public void caminos(){

    }

    /*
     * Ã�rbol Binario Completo: Es un Ã¡rbol en el que todos los nodos tienen dos hijos y todas las hojas estÃ¡n en el mismo nivel.  
     */
    public boolean isCompleto(){
            return false;
    }

    


    public int cantidadHojas(){
            return 0;
    }

    public void listarUnNivel(int nivel){

    }
    
    public NodoArbol buscarMinIzq() {
        NodoArbol actual = this.raiz;
        while( actual.getIzq()!=null ) {
            actual = actual.getIzq();
        }
        return actual;
    }
   public NodoArbol buscarMinDer() {
        NodoArbol actual = this.raiz;
        while( actual.getDer()!=null ) {
            actual = actual.getDer();
        }
        return actual;
    }
   
   /*
     * 
        Pre: El nodo no debe ser la raiz
        Post: Si existe el elemento con igual clave lo elimina. Luego de la eliminacion el arbol debe ser ABB
     */
   //SE PUEDE MEJORAR
    @Override
    public void eliminar(String a) {
        NodoArbol paraEliminar = buscar(a);
        ArbolBinario subArbol=new ArbolBinario();
        subArbol.setRaiz(paraEliminar);
        if (!subArbol.isEmpty()) {
            if (subArbol.isHoja()) 
            {
                this.borrarHoja(a);//ver si estoy borrando la referencia
            }
            else {
                if (subArbol.raiz.getIzq()!=null && subArbol.raiz.getDer()!=null) {
                    
                    ArbolBinario nuevoSubArb=new ArbolBinario();
                    nuevoSubArb.setRaiz(subArbol.getRaiz().getIzq());
                    NodoArbol aux=nuevoSubArb.buscarMinDer();
                    this.borrarHoja(aux.getClave());
                    NodoArbol padre =this.padre(subArbol.raiz.getClave());
                    if(subArbol.raiz.getClave().compareTo(padre.getClave())>0){
                        padre.setDer(aux);
                    }else padre.setIzq(aux);
                    aux.setIzq(subArbol.raiz.getIzq());
                    aux.setDer(subArbol.raiz.getDer());                   
                }
                else {
                    NodoArbol padre =this.padre(subArbol.raiz.getClave());
                    if (subArbol.raiz.getIzq()==null) {                   
                        if(subArbol.raiz.getClave().compareTo(padre.getClave())>0){
                        padre.setDer(subArbol.raiz.getDer());
                        }else padre.setIzq(subArbol.raiz.getDer());
                        
                    }else{
                        if(subArbol.raiz.getClave().compareTo(padre.getClave())>0){
                        padre.setDer(subArbol.raiz.getIzq());
                        }else padre.setIzq(subArbol.raiz.getIzq());
                    }
                }
            }
        }
    }

    //pre: la clave pertenece a una hoja
    //SE PUIEDE MEJORAR UTILIZANDO LA DE PADRE
    public void borrarHoja(String clave){
            if(!this.isEmpty()){
                    ArbolBinario aux = new ArbolBinario();
                    if (clave==this.raiz.getClave()){
                            this.raiz=null;
                            aux.raiz=null;
                    }
                    if (this.raiz!=null && this.raiz.getIzq()!=null && clave==this.raiz.getIzq().getClave()){
                            this.raiz.setIzq(null);
                            aux.raiz=null;
                    }
                    if (this.raiz!=null && this.raiz.getDer()!=null && clave==this.raiz.getDer().getClave()){
                            this.raiz.setDer(null);
                            aux.raiz=null;
                    }
                    if (this.raiz!=null && clave.compareTo(this.raiz.getClave())<0){
                            aux.raiz = this.raiz.getIzq();
                    }
                    if (this.raiz!=null && clave.compareTo(this.raiz.getClave())>0){
                            aux.raiz = this.raiz.getDer();
                    }
                    aux.borrarHoja(clave);
            }
    }
    //funcion que me retorna el nodo padre
    //pre: no es raiz
    //NO ES BUENO QUE RECORRA EL ARBOL PARA BUSCAR EL PADRE
    public NodoArbol padre(String clave){
            if(!this.isEmpty()){
                    ArbolBinario aux = new ArbolBinario();
                    if (clave.compareTo(this.raiz.getClave()) ==0){
                            this.raiz=null;
                    }
                    if (this.raiz.getIzq()!=null && clave==this.raiz.getIzq().getClave()){
                            return this.raiz;
                    }
                    if (this.raiz.getDer()!=null && clave==this.raiz.getDer().getClave()){
                            return this.raiz;
                    }
                    if (clave.compareTo(this.raiz.getClave())<0){
                            aux.raiz = this.raiz.getIzq();
                    }
                    if (clave.compareTo(this.raiz.getClave()) >0){
                            aux.raiz = this.raiz.getDer();
                    }
                    return aux.padre(clave);
            }
            else return null;
    }
    @Override
    public void vaciar(){
        this.raiz=null;
        this.cantidadNodos=0;
    }
}
