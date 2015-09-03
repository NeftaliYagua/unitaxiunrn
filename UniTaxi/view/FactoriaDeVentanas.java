package view;


public class FactoriaDeVentanas {
	
	private static PedidoView pedidoView = null;
	private static RadioTaxiView radioTaxi = null;
	private static DetallePedidoView detallePedidoView=null;
	
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
	
	public static DetallePedidoView getDetallePedidoViewInstance(){
		if (detallePedidoView == null) {
			detallePedidoView = new DetallePedidoView();
			return detallePedidoView;
		}else{
			return detallePedidoView;
		}
	}

}
