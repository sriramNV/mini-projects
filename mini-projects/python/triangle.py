# TimePass: creating program to calculate triangles

import matplotlib.pyplot as plt
import math

def findAllAngles(a,b,c):
    angleA = math.cos(((b*b)+(c*c)-(a*a))/(2*b*c)) 
    angleB = math.cos(((a*a)+(c*c)-(b*b))/(2*a*c)) 
    angleC = math.cos(((a*a)+(b*b)-(c*c))/(2*a*b)) 

    return math.degrees(angleA), math.degrees(angleB), math.degrees(angleC)


def findTwoSides(A,B,C,a):
    Arad = math.radians(A)
    Brad = math.radians(B)
    Crad = math.radians(C)

    b = ((a*math.sin(Brad))/math.sin(Arad))
    c = ((a*math.sin(Crad))/math.sin(Arad))
    
    return b, c


def createString(*conditions):
    result = []
    strings = ['an Equilateral', 'an Isoceles', 'Scalene', 'Right', 'an Acute', 'an Obtuse']

    for i, condition in enumerate(conditions):
        if condition:
            result.append(strings[i])
    
    if len(result) > 1:
        result[-2:] = [' and '.join(result[-2:])]

    return ', '.join(result)

def validTriangle(a,b,c):
    if a + b > c and a + c > b and b + c > a:
        return True
    else:
        return False



def triangle(n):
    a,b,c = n[0],n[1],n[2]

    if (validTriangle(a,b,c)):

        angleA, angleB, angleC = findAllAngles(a,b,c) # type: ignore

        equilateral = all(side == n[0] for side in n)
        isoceles = True if not equilateral and (n[0] == n[1] or n[0] == n[2] or n[1] == n[2]) else False
        scalene = True if angleA != angleB and angleB != angleC and angleA != angleC and a != b and a != c and b != c else False 
        right = True if 90 == int(angleA) or 90 == int(angleB) or 90 == int(angleC) else False
        acute = True if 90 > int(angleA) or 90 > int(angleB) or 90 > int(angleC) else False
        obtuse = True if 90 < int(angleA) or 90 < int(angleB) or 90 < int(angleC) else False

        triangle = createString(equilateral, isoceles, scalene, right, acute, obtuse)

        print(f'This is {triangle} triangle and the angles are {angleA:.2f}, {angleB:.2f}, {angleC:.2f}')
        draw_triangle(a, b, c)

    else:
        print('Invalid sides, triangle cannot be formed for given sides')


def draw_triangle(a, b, c):
    # Use the Law of Cosines to calculate the angle between sides a and b
    angle_C = math.acos((a**2 + b**2 - c**2) / (2 * a * b))  # Angle at vertex C
    
    # Calculate the coordinates of the three vertices
    A = (0, 0)  # First vertex at origin
    B = (b, 0)  # Second vertex along the x-axis
    
    # Use polar coordinates to find the third vertex
    C_x = a * math.cos(angle_C)
    C_y = a * math.sin(angle_C)
    C = (C_x, C_y)
    
    # Define the x and y coordinates for the triangle
    x = [A[0], B[0], C[0], A[0]]
    y = [A[1], B[1], C[1], A[1]]
    
    # Create the plot
    plt.figure()
    plt.fill(x, y, 'b', edgecolor='black')  # Fill the triangle with blue and add black edges
    plt.xlim(min(x)-1, max(x)+1)
    plt.ylim(min(y)-1, max(y)+1)

    # Display the triangle
    plt.title(f"Triangle with sides {a}, {b}, {c}")
    plt.grid(True)
    plt.gca().set_aspect('equal', adjustable='box')
    plt.show()

# Example usage with sides a=5, b=6, and c=7






n = list(map(float, input('Enter the size of 3 sides of the triangle seperated by space: ').split()))
triangle(n)
