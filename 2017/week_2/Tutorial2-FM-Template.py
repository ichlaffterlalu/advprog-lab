#	Mandatory 3: Create a program so it implement Factory Method Pattern. There are a template class to use Factory Method Pattern but you are free to explore your idea in implementing Factory Method Pattern.

def main():
	board = Board3x3()
	print (board)

class AbstractBoard:
	
	def __init__(self, rows, columns):
		self.board = [[None for _ in range(columns)] for _ in range(rows)]
		self.populate_board()
		
	def populate_board(self):
		raise NotImplementedError()

	def __str__(self):
		squares = []
		for x, row in enumerate(self.board):
			for y, column in enumerate(self.board):
				squares.append(self.board[x][y])
			squares.append("\n")
		return "".join(squares)

class Board3x3(AbstractBoard):
	def __init__(self):
		super().__init__(3, 3)
		
	def populate_board(self):
		for row in range(3):
			for column in range(3):
				if (column % 2): self.board[row][column] = "o"
				else: self.board[row][column] = "x"

# Mandatory 3: Uncomment the codes below
# class Piece(str):
	# __slots__ = ()
	
# class Circle(Piece):
# Mandatory 3: Implement the Factory Method in here

# class Cross(Piece):
# Mandatory 3: Implement the Factory Method in here

if __name__ == "__main__":
    main()
				
