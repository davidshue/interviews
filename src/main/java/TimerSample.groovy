def timer = new Timer()
def task = timer.runAfter(10000) {
	println "Actually executed at ${new Date()}."
}
println "Current date is ${new Date()}. Task is executed at ${new Date(task.scheduledExecutionTime())}."

def calendar = Calendar.instance

def future = Calendar.instance

future.set(year:2018)

println calendar.toInstant()
println future.toInstant()

calendar.upto(future) {
	println it.toInstant()
}