#	Mandatory 9: Edit IdnCurrRates class to a Singleton class
class IdnCurrRates (object):
	def __init__(self,rates):
		self.rates = rates
	def __str__(self):
		return str(self.rates)
		
x = IdnCurrRates(10000)
print ('Rates x: '+ str(x))
y = IdnCurrRates(20000)
print ('Rates y: ' + str(y))
z = IdnCurrRates(30000)
print ('Rates z: ' + str(z))
print ('X and Y condition should be 30000')
print ('Rates x: '+ str(x))
print ('Rates y: ' + str(y))
