import React from 'react';
import { MapContainer, TileLayer, Marker } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import { LocationCitySharp } from '@mui/icons-material';
import L from "leaflet";

const Map = ({ lat, lng }) => {
  const customIcon = new L.Icon({
    iconUrl: LocationCitySharp,
    iconSize: [32, 32],
    iconAnchor: [16, 32],
    popupAnchor: [0, -32],
  })

  return (
    <MapContainer center={[lat, lng]} zoom={13} style={{ height: '20vh', width: '100%' }}>
      <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />
      <Marker position={[lat, lng]} icon={customIcon}/>
    </MapContainer>
  );
};

export default Map;
