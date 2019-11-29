#!/usr/bin/env bash
set -e
time java --enable-preview -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/G1.jfr,maxsize=1024m,settings=profile org.przybyl.efNewJav.demo.gc.QuasiBenchmark
time java --enable-preview -XX:+UseParallelOldGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/ParallelOld.jfr,maxsize=1024m,settings=profile org.przybyl.efNewJav.demo.gc.QuasiBenchmark
time java --enable-preview -XX:+UseConcMarkSweepGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/CMS.jfr,maxsize=1024m,settings=profile org.przybyl.efNewJav.demo.gc.QuasiBenchmark
time java --enable-preview -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/Shenandoah.jfr,maxsize=1024m,settings=profile org.przybyl.efNewJav.demo.gc.QuasiBenchmark
time java --enable-preview -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=/tmp/ZGC.jfr,maxsize=1024m,settings=profile org.przybyl.efNewJav.demo.gc.QuasiBenchmark