$(document).ready(function(){
    var data = [10,20,30,40];
    var data2 = [20,30,40,50,60];

    render(data);

    setTimeout(function(){
        render(data2);
    }, 3000);
});

function render(data){
    var dataJoin = d3.select(".target")
        .selectAll("span")
        .data(data);

    // more point
    dataJoin.enter()
        .append("span")
        .style("width", function(d){
            return d + "px";
        });

    // less point
    dataJoin.exit()
        .remove();

    // same point
    dataJoin.style("width", function(d){
            return d + "px";
        });
}
