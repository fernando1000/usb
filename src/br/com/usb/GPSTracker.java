package br.com.usb;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

public class GPSTracker extends Service implements LocationListener{

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 metros, distancia minima para considerar atualizacoes
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute, tempo minimo entre atualizacoes em milisegundos
	private boolean isGPSEnabled = false;
	private boolean canGetLocation = false;
	private boolean isNetworkEnabled = false;
	private double latitude;
	private double longitude;
	private Location location; 
	private final Context context; 
	protected LocationManager locationManager;

    public GPSTracker(Context _context) {
    	 
    	this.context = _context;
        getLocation();
    }
        
    public Location getLocation() {
    	
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
 
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
 
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
 
            if (!isGPSEnabled && !isNetworkEnabled) {
                // nenhuma rede esta habilitada
            } 
            else {
            	
                this.canGetLocation = true;
                
                if (isNetworkEnabled) {
                	
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                            
                    if (locationManager != null) {
                    	
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        
                        if (location != null) {
                        	
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
                
                if (isGPSEnabled) {
                	
                    if (location == null) {
                    	
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        
                        if (locationManager != null) {
                        	
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            
                            if (location != null) {
                            	
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
 
        return location;
    }
    
    public boolean canGetLocation() {
        return this.canGetLocation;
    }
         
    public void mostraAlertDialogDoGPS(){
    	
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        					alertDialog.setTitle("Ativação do GPS");
        					alertDialog.setMessage("Confirma ativação do GPS?");
        					alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
        						public void onClick(DialogInterface dialog,int which) {
            	
        							Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        							context.startActivity(intent);
        						}
        					});
  
        					alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
        						public void onClick(DialogInterface dialog, int which) {
            	
        							dialog.cancel();
        						}
        					});
  
        					alertDialog.show();
    }
    
    public double getLatitude(){
    	
        if(location != null){
            latitude = location.getLatitude();
        }        
        return latitude;
    }
     
    public double getLongitude(){
    	
        if(location != null){
            longitude = location.getLongitude();
        }     
        return longitude;
    }

    @Override
    public void onLocationChanged(Location location) {
    }
    @Override
    public void onProviderDisabled(String provider) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

}
