''' game, you must guess a secret three-digit number based on clues. The game offers one of the following hints in response to your 
 guess: “Pico” when your guess has a correct digit in the wrong place, “Fermi” when your guess has a correct digit in the correct
 place, and “Bagels” if your guess has no correct digits. You have 10 tries to guess the secret number.'''

import random

NUM_DIGITS = 3
MAX_GUESSES = 10

def main():
    print('Bagels, a deductive logic game.')
    print('I am thinking of a %s-digit number. Try to guess what it is.' % NUM_DIGITS)
    print('Here are some clues:')
    print('When I say:    That means:')
    print('  Bagels      None of the digits is correct.')
    print('  Pico        One digit is correct but in the wrong place.')
    print('  Fermi       One digit is correct and in the right place.')
    print('For example, if the secret number was 248 and your guess was 843, the clues would be Fermi Pico.'.format(NUM_DIGITS))

    while(True):
        secretNum = getSecretNum()
        print('I have thought up a number.')
        print('You have %s guesses to get it.' % MAX_GUESSES)

        numGuesses = 1
        while(numGuesses <= MAX_GUESSES):
            guess = ''
            
            while(len(guess) != NUM_DIGITS or not guess.isdecimal()):
                print('Guess #%s: ' % numGuesses)
                guess = input('> ')

            clues = getClues(guess, secretNum)
            print(clues)
            numGuesses += 1

            if(guess == secretNum):
                break
            if(numGuesses > MAX_GUESSES):
                print('You ran out of guesses. The answer was %s.' % secretNum)
        print('Do you want to play again? (yes or no)')
        if not input('> ').lower().startswith('y'):
            break
    print('Thanks for playing!')


def getSecretNum():
    numbers = list(range(10))
    random.shuffle(numbers)
    return str(''.join(map(str, numbers[:NUM_DIGITS])))

def getClues(guess, secretNum):
    if guess == secretNum:
        return 'You got it!'

    clues = []
    for i in range(len(guess)):
        if guess[i] == secretNum[i]:
            clues.append('Fermi')
        elif guess[i] in secretNum:
            clues.append('Pico')
    if len(clues) == 0:
        return 'Bagels'
    else:
        # clues.sort()
        return ' '.join(clues)

if __name__ == '__main__':
    main()