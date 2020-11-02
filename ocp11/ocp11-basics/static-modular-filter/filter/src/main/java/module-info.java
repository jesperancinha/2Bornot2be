module filter {
    exports org.jesperancinha.ocp11.staticmodular.filter;
    requires api;
    provides org.jesperancinha.ocp11.staticmodular.api.Filter with org.jesperancinha.ocp11.staticmodular.filter.GreatFilter;
}