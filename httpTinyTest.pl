#!/usr/bin/env perl
use 5.14.0;
use warnings;
use HTTP::Tiny;

my $ua = HTTP::Tiny->new(
  agent => "HTTP-Tiny",
  timeout => 10,
);

my $delay = 0;
for my $i (1..5) {
  makeRequest($i);
  $delay += $i;
  say "Sleeping $delay sec";
  sleep $delay;
}

sub makeRequest {
  my $iter = shift;
  my $r = $ua->get("http://localhost:8080/ping");
  if ($r->{content} =~ /pong/) {
    say "GET #$iter successful.";
  }
  else {
    die "GET #$iter failed.";
  }
}

