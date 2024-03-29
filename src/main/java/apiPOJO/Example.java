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
"cod",
"message",
"city",
"cnt",
"list"
})
public class Example {

@JsonProperty("cod")
private String cod;
@JsonProperty("message")
private Integer message;
@JsonProperty("city")
private City city;
@JsonProperty("cnt")
private Integer cnt;
@JsonProperty("list")
private java.util.List<apiPOJO.List> list = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("cod")
public String getCod() {
return cod;
}

@JsonProperty("cod")
public void setCod(String cod) {
this.cod = cod;
}

@JsonProperty("message")
public Integer getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(Integer message) {
this.message = message;
}

@JsonProperty("city")
public City getCity() {
return city;
}

@JsonProperty("city")
public void setCity(City city) {
this.city = city;
}

@JsonProperty("cnt")
public Integer getCnt() {
return cnt;
}

@JsonProperty("cnt")
public void setCnt(Integer cnt) {
this.cnt = cnt;
}

@JsonProperty("list")
public java.util.List<apiPOJO.List> getList() {
return list;
}

@JsonProperty("list")
public void setList(java.util.List<apiPOJO.List> list) {
this.list = list;
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