package br.com.usb;

import java.util.Set;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

public class ProcuraDispositivosPareados {

	public String procurar() {

		String nome_MAC_encontrado = "";
		
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		if (bluetoothAdapter == null) {
			
			nome_MAC_encontrado = "Não encontrada";
		} 
		else {
			Set<BluetoothDevice> dispositivosPareados = bluetoothAdapter.getBondedDevices();

			if (dispositivosPareados.size() > 0) {

				for (BluetoothDevice bluetoothDevice : dispositivosPareados) {
					nome_MAC_encontrado = "" + bluetoothAdapter.getRemoteDevice(bluetoothDevice.getAddress());
				}
			}
		}
		return nome_MAC_encontrado;
	}

}
