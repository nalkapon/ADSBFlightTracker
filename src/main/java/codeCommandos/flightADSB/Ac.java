package codeCommandos.flightADSB;


import java.util.ArrayList;

public class Ac{
    private int alert;
    private int alt_baro;
    private int alt_geom;
    private int baro_rate;
    private String category;
    private String emergency;
    private String flight;
    private int gs;
    private int gva;
    private String hex;
    private double lat;
    private double lon;
    private int messages;
    private ArrayList<String> mlat;
    private int nac_p;
    private int nac_v;
    private int nav_altitude_mcp;
    private int nav_heading;
    private int nav_qnh;
    private int nic;
    private int nic_baro;
    private String r;
    private int rc;
    private int rssi;
    private int sda;
    private int seen;
    private int seen_pos;
    private int sil;
    private String sil_type;
    private int spi;
    private String squawk;
    private String t;
    private ArrayList<String> tisb;
    private int track;
    private String type;
    private int version;
    private int geom_rate;
    private int dbFlags;
    private ArrayList<String> nav_modes;
    private int true_heading;
    private int ias;
    private int mach;
    private int mag_heading;
    private int oat;
    private int roll;
    private int tas;
    private int tat;
    private int track_rate;
    private int wd;
    private int ws;
    private int gpsOkBefore;
    private int gpsOkLat;
    private int gpsOkLon;
    private int rr_lat;
    private int rr_lon;
    private int calc_track;
    private int nav_altitude_fms;
    private int heading;
    public String getFlight() {
        return flight;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }

    public int getAlt_baro() {
        return alt_baro;
    }

    public void setAlt_baro(int alt_baro) {
        this.alt_baro = alt_baro;
    }

    public int getAlt_geom() {
        return alt_geom;
    }

    public void setAlt_geom(int alt_geom) {
        this.alt_geom = alt_geom;
    }

    public int getBaro_rate() {
        return baro_rate;
    }

    public void setBaro_rate(int baro_rate) {
        this.baro_rate = baro_rate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public int getGs() {
        return gs;
    }

    public void setGs(int gs) {
        this.gs = gs;
    }

    public int getGva() {
        return gva;
    }

    public void setGva(int gva) {
        this.gva = gva;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }

    public ArrayList<String> getMlat() {
        return mlat;
    }

    public void setMlat(ArrayList<String> mlat) {
        this.mlat = mlat;
    }

    public int getNac_p() {
        return nac_p;
    }

    public void setNac_p(int nac_p) {
        this.nac_p = nac_p;
    }

    public int getNac_v() {
        return nac_v;
    }

    public void setNac_v(int nac_v) {
        this.nac_v = nac_v;
    }

    public int getNav_altitude_mcp() {
        return nav_altitude_mcp;
    }

    public void setNav_altitude_mcp(int nav_altitude_mcp) {
        this.nav_altitude_mcp = nav_altitude_mcp;
    }

    public int getNav_heading() {
        return nav_heading;
    }

    public void setNav_heading(int nav_heading) {
        this.nav_heading = nav_heading;
    }

    public int getNav_qnh() {
        return nav_qnh;
    }

    public void setNav_qnh(int nav_qnh) {
        this.nav_qnh = nav_qnh;
    }

    public int getNic() {
        return nic;
    }

    public void setNic(int nic) {
        this.nic = nic;
    }

    public int getNic_baro() {
        return nic_baro;
    }

    public void setNic_baro(int nic_baro) {
        this.nic_baro = nic_baro;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getSda() {
        return sda;
    }

    public void setSda(int sda) {
        this.sda = sda;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public int getSeen_pos() {
        return seen_pos;
    }

    public void setSeen_pos(int seen_pos) {
        this.seen_pos = seen_pos;
    }

    public int getSil() {
        return sil;
    }

    public void setSil(int sil) {
        this.sil = sil;
    }

    public String getSil_type() {
        return sil_type;
    }

    public void setSil_type(String sil_type) {
        this.sil_type = sil_type;
    }

    public int getSpi() {
        return spi;
    }

    public void setSpi(int spi) {
        this.spi = spi;
    }

    public String getSquawk() {
        return squawk;
    }

    public void setSquawk(String squawk) {
        this.squawk = squawk;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public ArrayList<String> getTisb() {
        return tisb;
    }

    public void setTisb(ArrayList<String> tisb) {
        this.tisb = tisb;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getGeom_rate() {
        return geom_rate;
    }

    public void setGeom_rate(int geom_rate) {
        this.geom_rate = geom_rate;
    }

    public int getDbFlags() {
        return dbFlags;
    }

    public void setDbFlags(int dbFlags) {
        this.dbFlags = dbFlags;
    }

    public ArrayList<String> getNav_modes() {
        return nav_modes;
    }

    public void setNav_modes(ArrayList<String> nav_modes) {
        this.nav_modes = nav_modes;
    }

    public int getTrue_heading() {
        return true_heading;
    }

    public void setTrue_heading(int true_heading) {
        this.true_heading = true_heading;
    }

    public int getIas() {
        return ias;
    }

    public void setIas(int ias) {
        this.ias = ias;
    }

    public int getMach() {
        return mach;
    }

    public void setMach(int mach) {
        this.mach = mach;
    }

    public int getMag_heading() {
        return mag_heading;
    }

    public void setMag_heading(int mag_heading) {
        this.mag_heading = mag_heading;
    }

    public int getOat() {
        return oat;
    }

    public void setOat(int oat) {
        this.oat = oat;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getTas() {
        return tas;
    }

    public void setTas(int tas) {
        this.tas = tas;
    }

    public int getTat() {
        return tat;
    }

    public void setTat(int tat) {
        this.tat = tat;
    }

    public int getTrack_rate() {
        return track_rate;
    }

    public void setTrack_rate(int track_rate) {
        this.track_rate = track_rate;
    }

    public int getWd() {
        return wd;
    }

    public void setWd(int wd) {
        this.wd = wd;
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public int getGpsOkBefore() {
        return gpsOkBefore;
    }

    public void setGpsOkBefore(int gpsOkBefore) {
        this.gpsOkBefore = gpsOkBefore;
    }

    public int getGpsOkLat() {
        return gpsOkLat;
    }

    public void setGpsOkLat(int gpsOkLat) {
        this.gpsOkLat = gpsOkLat;
    }

    public int getGpsOkLon() {
        return gpsOkLon;
    }

    public void setGpsOkLon(int gpsOkLon) {
        this.gpsOkLon = gpsOkLon;
    }

    public int getRr_lat() {
        return rr_lat;
    }

    public void setRr_lat(int rr_lat) {
        this.rr_lat = rr_lat;
    }

    public int getRr_lon() {
        return rr_lon;
    }

    public void setRr_lon(int rr_lon) {
        this.rr_lon = rr_lon;
    }

    public int getCalc_track() {
        return calc_track;
    }

    public void setCalc_track(int calc_track) {
        this.calc_track = calc_track;
    }

    public int getNav_altitude_fms() {
        return nav_altitude_fms;
    }

    public void setNav_altitude_fms(int nav_altitude_fms) {
        this.nav_altitude_fms = nav_altitude_fms;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }
}

