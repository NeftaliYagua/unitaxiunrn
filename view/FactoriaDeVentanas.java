package view;


public class FactoriaDeVentanas {
	
	private static PedidoView pedidoView = null;
	private static RadioTaxiView radioTaxi = null;
	
	public static PedidoView getPedidoViewInstance(){
		if (pedidoView == null) {
			pedidoView = new PedidoView();
			return pedidoView;
		}else{
			return pedidoView;
		}
	}
	
	public static RadioTaxiView getRadioTaxiInstance(){
		if (radioTaxi == null) {
			radioTaxi = new RadioTaxiView();
			return radioTaxi;
		}else{
			return radioTaxi;
		}
	}

}
