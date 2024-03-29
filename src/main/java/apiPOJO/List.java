package apiPOJO;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"dt",
"temp",
"pressure",
"humidity",
"weather",
"speed",
"deg",
"clouds",
"snow"
})
public class List {

@JsonProperty("dt")
private Integer dt;
@JsonProperty("temp")
private Temp temp;
@JsonProperty("pressure")
private Double pressure;
@JsonProperty("humidity")
private Integer humidity;
@JsonProperty("weather")
private java.util.List<Weather> weather = null;
@JsonProperty("speed")
private Double speed;
@JsonProperty("deg")
private Integer deg;
@JsonProperty("clouds")
private Integer clouds;
@JsonProperty("snow")
private Double snow;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("dt")
public Integer getDt() {
return dt;
}

@JsonProperty("dt")
public void setDt(Integer dt) {
this.dt = dt;
}

@JsonProperty("temp")
public Temp getTemp() {
return temp;
}

@JsonProperty("temp")
public void setTemp(Temp temp) {
this.temp = temp;
}

@JsonProperty("pressure")
public Double getPressure() {
return pressure;
}

@JsonProperty("pressure")
public void setPressure(Double pressure) {
this.pressure = pressure;
}

@JsonProperty("humidity")
public Integer getHumidity() {
return humidity;
}

@JsonProperty("humidity")
public void setHumidity(Integer humidity) {
this.humidity = humidity;
}

@JsonProperty("weather")
public java.util.List<Weather> getWeather() {
return weather;
}

@JsonProperty("weather")
public void setWeather(java.util.List<Weather> weather) {
this.weather = weather;
}

@JsonProperty("speed")
public Double getSpeed() {
return speed;
}

@JsonProperty("speed")
public void setSpeed(Double speed) {
this.speed = speed;
}

@JsonProperty("deg")
public Integer getDeg() {
return deg;
}

@JsonProperty("deg")
public void setDeg(Integer deg) {
this.deg = deg;
}

@JsonProperty("clouds")
public Integer getClouds() {
return clouds;
}

@JsonProperty("clouds")
public void setClouds(Integer clouds) {
this.clouds = clouds;
}

@JsonProperty("snow")
public Double getSnow() {
return snow;
}

@JsonProperty("snow")
public void setSnow(Double snow) {
this.snow = snow;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
