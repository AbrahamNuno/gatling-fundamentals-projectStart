var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "10",
        "ok": "0",
        "ko": "10"
    },
    "minResponseTime": {
        "total": "11",
        "ok": "-",
        "ko": "11"
    },
    "maxResponseTime": {
        "total": "116",
        "ok": "-",
        "ko": "116"
    },
    "meanResponseTime": {
        "total": "35",
        "ok": "-",
        "ko": "35"
    },
    "standardDeviation": {
        "total": "37",
        "ok": "-",
        "ko": "37"
    },
    "percentiles1": {
        "total": "14",
        "ok": "-",
        "ko": "14"
    },
    "percentiles2": {
        "total": "41",
        "ok": "-",
        "ko": "41"
    },
    "percentiles3": {
        "total": "107",
        "ok": "-",
        "ko": "107"
    },
    "percentiles4": {
        "total": "114",
        "ok": "-",
        "ko": "114"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 10,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.909",
        "ok": "-",
        "ko": "0.909"
    }
},
contents: {
"req_get-specific-vi-653d7": {
        type: "REQUEST",
        name: "Get Specific Video Game",
path: "Get Specific Video Game",
pathFormatted: "req_get-specific-vi-653d7",
stats: {
    "name": "Get Specific Video Game",
    "numberOfRequests": {
        "total": "10",
        "ok": "0",
        "ko": "10"
    },
    "minResponseTime": {
        "total": "11",
        "ok": "-",
        "ko": "11"
    },
    "maxResponseTime": {
        "total": "116",
        "ok": "-",
        "ko": "116"
    },
    "meanResponseTime": {
        "total": "35",
        "ok": "-",
        "ko": "35"
    },
    "standardDeviation": {
        "total": "37",
        "ok": "-",
        "ko": "37"
    },
    "percentiles1": {
        "total": "14",
        "ok": "-",
        "ko": "14"
    },
    "percentiles2": {
        "total": "41",
        "ok": "-",
        "ko": "41"
    },
    "percentiles3": {
        "total": "107",
        "ok": "-",
        "ko": "107"
    },
    "percentiles4": {
        "total": "114",
        "ok": "-",
        "ko": "114"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 10,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.909",
        "ok": "-",
        "ko": "0.909"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
