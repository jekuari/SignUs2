package main

import (
	"os/exec"
)

func main() {

	// run java -cp /home/rfere/Documents/Utexas/Java/signUs2/SignUs2/bin App

	executor := exec.Command("java", "-cp", "../bin", "App").Run()

	if executor != nil {
		panic(executor)
	}
}
